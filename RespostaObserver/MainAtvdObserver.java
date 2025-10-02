package RespostaObserver;

import java.util.ArrayList;

interface Observer {
    void update(String tarefa);
}

interface Subject {
    void adicionar(Aluno a);
    void remover(Aluno a);
    void notificar(String tarefa);
}

class Aluno implements Observer {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String tarefa){
        System.out.println(nome + " recebeu a tarefa: " + tarefa);
    }
}

class Professor implements Subject {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    @Override
    public void adicionar(Aluno a) {
        alunos.add(a);
    }

    @Override
    public void remover(Aluno a) {
        alunos.remove(a);
    }

    public void notificar(String tarefa) {
        for (Aluno aluno : alunos) {
            aluno.update(tarefa);
        }
    }

    public void postarTarefa(String tarefa){
        System.out.println("Professor postou:"+tarefa);

        notificar(tarefa);
    }
}

class App {
    public static void main(String[] args) throws Exception {
        Professor prof = new Professor();
        Aluno a1 = new Aluno("Joao");
        Aluno a2 = new Aluno("Maria");
        prof.adicionar(a1);
        prof.adicionar(a2);
        prof.postarTarefa("Ler capitulo 5 ");
    }
}
