import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TextoProfundo {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java TextoProfundo <URL>");
            return;
        }

        String CorpoDoHtml = args[0];
        //CorpoDoHtml = "http://hiring.axreng.com/internship/example1.html";

        try {
            URL urlHtml = new URL(CorpoDoHtml);
            HttpURLConnection connection = (HttpURLConnection) urlHtml.openConnection();
            connection.setRequestMethod("GET");

            //Definir limites de espera para conectar
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            BufferedReader br = new BufferedReader
                    (new InputStreamReader(connection.getInputStream()));

            String linha;
            int ContarDivs = 0; //Contar as divs do HTML
            int MaiorDiv = 0; //Armazenar texto mais profundo

            String TextoMaisProfundo = "";

            while ((linha = br.readLine()) != null) {

                linha = linha.trim();//Retirar espaços em branco

                if (linha.isEmpty()) continue; //Ignorar linhas em branco

                //Encontrar começo e final da div
                if (linha.startsWith("<") && linha.endsWith(">")) {
                    if (linha.startsWith("</")) {
                        ContarDivs--;
                    } else {
                        ContarDivs++;
                    }
                } else {//SE O NUMERO DE DIVS DESSE TEXTO ACHADO FOR MAIOR QUE
                    //DO ANTERIOR ELA SE TORNARA O MAIOR NUMERO DE DIVS

                    if (ContarDivs > MaiorDiv) {
                        MaiorDiv = ContarDivs;
                        TextoMaisProfundo = linha;
                    }
                }
            }
            if (ContarDivs < 0) {
                System.out.println("HTML mal formatado");
                return;
            }

            System.out.println("Texto de maior profundidade é : " + TextoMaisProfundo);
        }
        catch (MalformedURLException e) {
            System.out.println("malformed HTML");
        }
        catch (IOException e) {
            System.out.println("URL connection error");
        }
    }
}
