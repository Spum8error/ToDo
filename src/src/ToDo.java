package src;

import java.util.*;

class newDo{
    int nomberDo;
    String titleDo;
    String doIt;
    boolean clearDo = false;
}

public class ToDo {

    public static void main(String[] args) {
        boolean exitDo = false;
        boolean test = false;
        int toDocount = 0;
        Scanner console = new Scanner(System.in);
        String userInput;
        String temp;
        int nomRec = 0;
        ArrayList<newDo> ToDoRecord = new ArrayList<>();

        while (!exitDo){
            System.out.println("-Сделать новую запись: введите 'new' ");
            System.out.println("--Вывод всех записей: введите 'show' ");
            System.out.println("---Исправить запись или отметить выполнение: введите 'edit' ");
            System.out.println("----Закончить работу: введите 'exit' ");

            userInput = console.nextLine();

            if (userInput.equals("exit")) {
                exitDo = true;
            } else {
                if (userInput.equals("new")) {

                    newDo Record = new newDo();

                    toDocount++;
                    System.out.println("-Введите заголовок записи: ");
                    Record.titleDo = console.nextLine();
                    System.out.println("-Введите запись: ");
                    Record.doIt = console.nextLine();
                    Record.nomberDo = toDocount;
                    Record.clearDo = true;

                    ToDoRecord.add(Record);

                } else {
                    if (userInput.equals("show")) {
                        newDo listRes = new newDo();
                        System.out.println("Всего записей: " + ToDoRecord.size());
                        for (int i=0; i<toDocount; i++){
                            listRes = ToDoRecord.get(i);
                            System.out.print (listRes.titleDo + " " + listRes.doIt);
                            System.out.println();
                        }
                    } else {
                        if (userInput.equals("edit") & (toDocount != 0)) {
                            newDo listRes = new newDo();
                            System.out.println("Имеются такие записи: ");
                            for (int i=0; i<toDocount; i++){
                                listRes = ToDoRecord.get(i);
                                System.out.print(i+1);
                                System.out.println("| " + listRes.titleDo + " " + listRes.doIt);
                            }
                            test = false;
                            while (!test){
                                try
                                {   System.out.println("Введите номер записи для редактирования или удаления: ");
                                    nomRec = console.nextInt()-1;
                                    console.nextLine();
                                    if ((nomRec < toDocount) & (nomRec > -1)) {
                                        test = true;
                                    } else System.out.println("!!! Неверный ввод, попробуйте ещё раз!");
                                }
                                catch (InputMismatchException e)
                                {
                                    console.nextLine();
                                    System.out.println("!!! Неверный ввод, попробуйте ещё раз!");
                                    test = false;
                                }
                            }

                            System.out.println("Если запись нужно удалить: введите 'del', если запись нужно редактировать: введите 'rec'");
                            temp = console.nextLine();
                            if (temp.equals("del")) {
                                ToDoRecord.remove(nomRec);
                                toDocount--;
                                System.out.println("Запись удалена! ");
                            }else {
                                if (temp.equals("rec")) {
                                    listRes = ToDoRecord.get(nomRec);
                                    System.out.println("Заголовок записи такой: " + listRes.titleDo);
                                    System.out.println("Введите новый заголовок: ");
                                    listRes.titleDo = console.nextLine();
                                    System.out.println("Текст записи такой: " + listRes.doIt);
                                    System.out.println("Введите новый текст: ");
                                    listRes.doIt = console.nextLine();
                                    ToDoRecord.set((nomRec),listRes);
                                    System.out.println("Запись изменена! ");
                                }else System.out.println("!!! Неверный ввод, попробуйте ещё раз! ");
                            }
                        } else System.out.println("!!! Неверный ввод, попробуйте ещё раз! ");
                    }
                }
            }
        }
    }
}
