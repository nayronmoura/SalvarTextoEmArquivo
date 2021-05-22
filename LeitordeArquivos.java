import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
public class LeitordeArquivos {
    //Variáveis da classe
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        File arquivo = Diretorio();//Pega o diretório
        System.out.println("qual o texto?");
        String Texto= input.next();//input
        Escrever(arquivo,Texto);//esse método escreve o texto no arquivo
    }
    public static void Escrever(File file,String texto) {
        try {
            FileWriter wr= new FileWriter(file);
            BufferedWriter buf = new BufferedWriter(wr);
            buf.write(texto);//escreve o texto dentro do arquivo
            buf.flush();//transforma o arquivo em bytes
            buf.close();
            System.out.println("arquivo escrito com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static File Diretorio(){
        JFileChooser pat = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        pat.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//selecionar apenas pastas
        int path = pat.showOpenDialog(null);//abre a pagina de dialogo
        if(path == JFileChooser.APPROVE_OPTION){
            return pat.getSelectedFile();
        }
        return null;
    }
}


