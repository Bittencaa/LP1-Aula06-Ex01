import java.text.SimpleDateFormat;
import java.util.*;

public class Controle {
    ArrayList<Aluno> listaAluno = new ArrayList<>();
    Map<String, String> nascimento = new HashMap<String, String>();
    Calendar data = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Scanner scan = new Scanner(System.in);
    String n;
    double p,s,mediaTurma = 0;

    public void cadastrarAluno() {
        do {
            Aluno aluno = new Aluno(n, p, s);
            System.out.println("Insira o nome: ");
            aluno.name = scan.next();
            if (aluno.name.equals("fim")){
                System.out.println("Fim da inclusão de alunos");
                break;
            }else{
                n = aluno.name;
            }
            System.out.println("Insira a primeira nota: ");
            aluno.pNota = scan.nextDouble();
            System.out.println("Insira a segunda nota: ");
            aluno.sNota = scan.nextDouble();
            if (aluno.pNota >= 0 && aluno.pNota <=100 && aluno.sNota >= 0 && aluno.sNota <= 100){
                p = aluno.pNota;
                s = aluno.sNota;
                listaAluno.add(aluno);
            }else{
                System.out.println("Insira valores válidos");
            }
        } while (true);
    }

    public void imprimirLista(){
        for (int i = 0; i < listaAluno.size(); i++){
            System.out.println("Aluno " + i + " " + listaAluno.get(i).name);
            System.out.println("__________");
            System.out.println("Nota primeira prova: " + listaAluno.get(i).pNota);
            System.out.println("__________");
            System.out.println("Nota segunda prova: " + listaAluno.get(i).sNota);
            System.out.println("__________");
            System.out.println("__________");
        }
    }

    public void mediaAlunos(){
        double media, soma, soma2 = 0;
        int contador = 0;
        for (int i = 0; i < listaAluno.size(); i++){
            soma = (listaAluno.get(i).pNota + listaAluno.get(i).sNota)/2;
            soma2 = soma2 + soma;
            contador ++;
        }
        media = soma2 / contador;
        System.out.println("____________________________________________");
        System.out.println("Média da turma: " + media);
        System.out.println("____________________________________________");
        mediaTurma = media;
    }

    public void aprovacao(){
        double mediaAluno;
        int aprovados = 0, reprovados = 0, finais = 0;
        for (int i = 0; i < listaAluno.size(); i++){
            mediaAluno = (listaAluno.get(i).pNota + listaAluno.get(i).sNota)/2;
            if (mediaAluno >= 60){
                aprovados++;
            }else if(mediaAluno > 40 && mediaAluno < 60){
                finais++;
            }else{
                reprovados++;
            }
        }
        System.out.println(aprovados + " aluno(s) foram aprovados");
        System.out.println("____________________________________________");
        System.out.println(reprovados + " aluno(s) foram reprovados");
        System.out.println("____________________________________________");
        System.out.println(finais + " aluno(s) ficaram de finais");
        System.out.println("____________________________________________");
        System.out.println("Códigos do(s) aluno(s) abaixo da média da turma: ");
        System.out.println("____________________________________________");

        for (int i = 0; i < listaAluno.size(); i++){
            mediaAluno = (listaAluno.get(i).pNota + listaAluno.get(i).sNota)/2;
            if (mediaAluno < mediaTurma){
                System.out.println(listaAluno.get(i));
                System.out.println("____________________________________________");
            }
        }
    }
    public void dataNasc(){
        int ano, mes, dia;
        for (int i = 0; i < listaAluno.size(); i++){
            System.out.println("Informe a data de nascimento do(a) aluno(a) " + listaAluno.get(i).name);
            System.out.println("Entre com o dia: ");
            dia = scan.nextInt();
            System.out.println("Entre com o mês: ");
            mes = scan.nextInt();
            System.out.println("Entre com o ano: ");
            ano = scan.nextInt();
            data.set(ano, mes, dia);
            nascimento.put(listaAluno.get(i).name,sdf.format(data.getTime()));
        }
    }
    public void exibirDatas(){
        for (int i = 0; i < listaAluno.size(); i++){
            System.out.println("____________________________________________");
            System.out.println(String.format("Data de nascimento do(a) aluno(a) " + listaAluno.get(i).name + ": " + nascimento.get(listaAluno.get(i).name)));
            System.out.println("____________________________________________");
        }
    }

    public void buscarDatas(){
        do{
            System.out.println("Entre com um aluno para exibir sua data de nascimento, ou digite 'fim' para encerrar o programa");
            System.out.println("____________________________________________");
            String nome;
            nome = scan.next();
            if (nome.equals("fim")) {
                break;
            }else if (nascimento.containsKey(nome)) {
                System.out.println("Data de nascimento: " + nascimento.get(nome));
                System.out.println("____________________________________________");
            }else{
                System.out.println("Aluno não encontrado");
                System.out.println("____________________________________________");
            }
        }while (true);
    }

}
