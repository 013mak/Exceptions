
public class Main {

    public static void main(String[] args) {
          InputData input = new InputData();
        try {
          String data = input.inputData();
          String split = input.getFilename();
            Write write = new Write();
            write.createFile(split);
            write.writeFile(split, data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }




    }


}
