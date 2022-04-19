import java.util.ArrayList;
import java.util.Scanner;

public class Controle {
    ArrayList<Aluno> listaAluno = new ArrayList<>();
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
            System.out.println("Aluno " + i);
            System.out.println("__________");
            System.out.println(listaAluno.get(i).name);
            System.out.println("__________");
            System.out.println("Nota primeira prova");
            System.out.println("__________");
            System.out.println(listaAluno.get(i).pNota);
            System.out.println("__________");
            System.out.println("Nota segunda prova");
            System.out.println("__________");
            System.out.println(listaAluno.get(i).sNota);
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
        System.out.println("Média da turma: " + media);
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
        System.out.println(aprovados + " alunos foram aprovados");
        System.out.println(reprovados + " alunos foram reprovados");
        System.out.println(finais + " alunos ficaram de finais");
        System.out.println("Códigos dos alunos abaixo da média da turma: ");

        for (int i = 0; i < listaAluno.size(); i++){
            mediaAluno = (listaAluno.get(i).pNota + listaAluno.get(i).sNota)/2;
            if (mediaAluno < mediaTurma){
                System.out.println(listaAluno.get(i));
            }
        }
    }

}
