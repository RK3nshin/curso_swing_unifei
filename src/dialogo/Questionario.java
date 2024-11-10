package dialogo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Questionario {

    public Questionario() {
    }

    private void exibirJanelaMensagem(JFrame frame, String nomeJanela, String mensagem, int messageType) {
        JOptionPane.showMessageDialog(frame, mensagem, nomeJanela, messageType);
    }

    private int exibirJanelaSelecao(JFrame frame, String nomeJanela,
            String mensagem, int tipoJanela, int tipoMensagem, Object[] opcoes) {

        int resposta = JOptionPane.showOptionDialog(frame, mensagem, nomeJanela, tipoJanela,
                tipoMensagem, null, opcoes, opcoes[0]);

        return resposta;
    }

    private String exibirJanelaEntrada(JFrame frame, String nomeJanela, String mensagem, int tipoMensagem) {
        String input = JOptionPane.showInputDialog(frame, mensagem, nomeJanela, tipoMensagem);
        return input;
    }

    public void caixaDialogo() {
        String titulo, mensagem;

        // Tela 1
        titulo = "Entrada";
        mensagem = "Qual é o seu nome ?";
        
        String nome = exibirJanelaEntrada(null, titulo, mensagem, JOptionPane.QUESTION_MESSAGE);

        while(nome == null || nome.isBlank()){
            if(nome == null)
                 return;

          nome = exibirJanelaEntrada(null, titulo, mensagem, JOptionPane.QUESTION_MESSAGE);

        }
         // Tela 2
         titulo = "Mensagem";
         mensagem = "Olá " + nome + ", seja bem vindo ao cuso de interface gráfica com java";

         exibirJanelaMensagem(null, titulo, mensagem, JOptionPane.INFORMATION_MESSAGE);


        // Tela 3
        titulo = "Selecionar uma Opção";
        mensagem = nome + " Você gosta de Programar?";
        Object[] opcoes = { "Sim", "Não", "Cancelar" };

        
        int resposta = exibirJanelaSelecao(null, titulo, mensagem, JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, opcoes);

        switch (resposta) {
            case JOptionPane.YES_OPTION:
                mensagem = "Então estude bem Java Swing. Ele pode abrir várias portas para você.";
                break;
            case JOptionPane.NO_OPTION:
                mensagem = "Que pena. Mas como as janelas, você vai gostar.";
                break;
            case JOptionPane.CANCEL_OPTION:
            case JOptionPane.CLOSED_OPTION:
                return;
            default:
                break;
        }

        exibirJanelaMensagem(null, titulo, mensagem, JOptionPane.INFORMATION_MESSAGE);
        // Tela 4
        titulo = "Atenção";
        mensagem = "Lembrete: aqui no Java Swing é tudo objeto. Você gosta disto?";
        Object[] opcoes2 = { "Sim - Objeto é legal", "Não - Objeto é sofrimento", "Talvez - Quero aprender" };

        resposta = exibirJanelaSelecao(null, titulo, mensagem, JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                opcoes2);

        switch (resposta) {
            case 0:
                mensagem = "Ótimo, todos os componentes são objetos!";
                break;
            case 1:
                mensagem = "Não se preocupe. Agora você irá aprender a importância dos objetos.";
                break;
            case 2:
                mensagem = "Sim, você aprenderá sobre objetos!";

        }

        exibirJanelaMensagem(null, titulo, mensagem, JOptionPane.INFORMATION_MESSAGE);
    }

}
