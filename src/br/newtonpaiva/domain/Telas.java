package br.newtonpaiva.domain;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class Telas {
    private String nome;
    private String sobrenome;
    private String telefone;
    private String produtoSelecionado;
    private String massaSelecionada;
    private String recheioSelecionado;
    private int quantidade = 0;


    public void tela1() {
        JFrame frame = new JFrame("Cadastro de Cliente: ");
        Container janela = frame.getContentPane();
        janela.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 50, 100, 20);
        JFormattedTextField txtNome = new JFormattedTextField(getNomeMaskFormatter());
        txtNome.setBounds(160, 50, 150, 20);

        JLabel lblSobrenome = new JLabel("Sobrenome:");
        lblSobrenome.setBounds(50, 80, 100, 20);
        JFormattedTextField txtSobrenome = new JFormattedTextField(getSobrenomeMaskFormatter());
        txtSobrenome.setBounds(160, 80, 150, 20);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(50, 110, 100, 20);
        JFormattedTextField txtTelefone = new JFormattedTextField(getTelefoneMaskFormatter());
        txtTelefone.setBounds(160, 110, 150, 20);

        JButton btnProximo = new JButton("Próximo");
        btnProximo.setBounds(160, 140, 100, 30);
        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nome = txtNome.getText();
                sobrenome = txtSobrenome.getText();
                telefone = txtTelefone.getText();
                telaProduto();
                frame.setVisible(false);
            }
        });

        janela.add(lblNome);
        janela.add(txtNome);
        janela.add(lblSobrenome);
        janela.add(txtSobrenome);
        janela.add(lblTelefone);
        janela.add(txtTelefone);
        janela.add(btnProximo);

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private MaskFormatter getNomeMaskFormatter() {
        MaskFormatter mascaraNome = null;
        try {
            mascaraNome = new MaskFormatter("U****************************");
            mascaraNome.setPlaceholderCharacter(' ');
        } catch (ParseException e) {
            System.err.println("Erro na formatação: " + e.getMessage());
            System.exit(-1);
        }
        return mascaraNome;
    }

    private MaskFormatter getSobrenomeMaskFormatter() {
        MaskFormatter mascaraSobrenome = null;
        try {
            mascaraSobrenome = new MaskFormatter("U****************************");
            mascaraSobrenome.setPlaceholderCharacter(' ');
        } catch (ParseException e) {
            System.err.println("Erro na formatação: " + e.getMessage());
            System.exit(-1);
        }
        return mascaraSobrenome;
    }

    private MaskFormatter getTelefoneMaskFormatter() {
        MaskFormatter mascaraTelefone = null;
        try {
            mascaraTelefone = new MaskFormatter("(##)#####-####");
            mascaraTelefone.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            System.err.println("Erro na formatação: " + e.getMessage());
            System.exit(-1);
        }
        return mascaraTelefone;
    }

    public void telaProduto() {
        JFrame frame = new JFrame("Produtos: ");
        Container janela = frame.getContentPane();
        janela.setLayout(null);

        JLabel lblProduto = new JLabel("Selecione o produto:");
        lblProduto.setBounds(50, 50, 200, 20);

        String[] opcoes = {"Bolo", "CupCake", "Dunet"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(50, 80, 140, 20);

        JButton btnProximo = new JButton("Próximo");
        btnProximo.setBounds(50, 110, 100, 30);
        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtoSelecionado = (String) comboBox.getSelectedItem();
                telaMassaBolo();
                frame.setVisible(false);
            }
        });

        janela.add(lblProduto);
        janela.add(comboBox);
        janela.add(btnProximo);

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void telaMassaBolo() {
        JFrame frame = new JFrame("Massas: ");
        Container janela = frame.getContentPane();
        janela.setLayout(null);

        JLabel lblMassa = new JLabel("Selecione a massa:");
        lblMassa.setBounds(50, 50, 200, 20);

        String[] opcoes = {"Chocolate", "Baunilha"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(50, 80, 140, 20);

        JButton btnProximo = new JButton("Próximo");
        btnProximo.setBounds(50, 110, 100, 30);
        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                massaSelecionada = (String) comboBox.getSelectedItem();
                telaRecheio();
                frame.setVisible(false);
            }
        });

        janela.add(lblMassa);
        janela.add(comboBox);
        janela.add(btnProximo);

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void telaRecheio() {
        JFrame frame = new JFrame("Recheios: ");
        Container janela = frame.getContentPane();
        janela.setLayout(null);

        JLabel lblRecheio = new JLabel("Selecione o recheio:");
        lblRecheio.setBounds(50, 50, 200, 20);

        String[] opcoes = {"Nutella", "Ninho", "Coco", "Doce de Leite"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(50, 80, 140, 20);

        JButton btnProximo = new JButton("Próximo");
        btnProximo.setBounds(50, 180, 100, 30);
        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recheioSelecionado = (String) comboBox.getSelectedItem();
                telaFinal();
                frame.setVisible(false);
            }
        });

        JLabel lblQuantidade = new JLabel("Quantidade: 0");
        lblQuantidade.setBounds(50, 140, 100, 20);

        JButton btnMais = new JButton("Adicionar");
        btnMais.setBounds(160, 140, 100, 20);
        btnMais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantidade++;
                lblQuantidade.setText("Quantidade: " + quantidade);
            }
        });

        JButton btnMenos = new JButton("Remover");
        btnMenos.setBounds(280, 140, 100, 20);
        btnMenos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quantidade > 0) {
                    quantidade--;
                    lblQuantidade.setText("Quantidade: " + quantidade);
                }
            }
        });

        janela.add(lblRecheio);
        janela.add(comboBox);
        janela.add(btnProximo);
        janela.add(lblQuantidade);
        janela.add(btnMais);
        janela.add(btnMenos);

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void telaFinal() {
        JFrame frame = new JFrame("Resumo do Pedido: ");
        Container janela = frame.getContentPane();
        janela.setLayout(null);

        JLabel lblNome = new JLabel("Nome: " + nome);
        lblNome.setBounds(50, 50, 200, 20);

        JLabel lblSobrenome = new JLabel("Sobrenome: " + sobrenome);
        lblSobrenome.setBounds(50, 80, 200, 20);

        JLabel lblTelefone = new JLabel("Telefone: " + telefone);
        lblTelefone.setBounds(50, 110, 200, 20);

        JLabel lblProduto = new JLabel("Produto: " + produtoSelecionado);
        lblProduto.setBounds(50, 140, 200, 20);

        JLabel lblMassa = new JLabel("Massa: " + massaSelecionada);
        lblMassa.setBounds(50, 170, 200, 20);

        JLabel lblRecheio = new JLabel("Recheio: " + recheioSelecionado);
        lblRecheio.setBounds(50, 200, 200, 20);

        JLabel lblQuantidade = new JLabel("Quantidade: " + quantidade);
        lblQuantidade.setBounds(50, 230, 200, 20);

        double valorFinal = 10.00 * quantidade;
        JLabel lblValorFinal = new JLabel("Valor Final: R$ " + valorFinal);
        lblValorFinal.setBounds(50, 260, 200, 20);


        // mude o path para onde voce criou o arquivo txt que deve obter as informações:
        String path = "C:\\Faculdade\\TrabalhoFinalRafaConfeitaria\\Pedido.txt";
        JOptionPane.showMessageDialog(null, "Seu pedido foi salvo em: " + path , "Pedido", JOptionPane.PLAIN_MESSAGE);
        try {
            FileWriter writer = new FileWriter(path);
            writer.write("Nome: " + nome + "\n");
            writer.write("Sobrenome: " + sobrenome + "\n");
            writer.write("Telefone: " + telefone + "\n");
            writer.write("Produto: " + produtoSelecionado + "\n");
            writer.write("Massa: " + massaSelecionada + "\n");
            writer.write("Recheio: " + recheioSelecionado + "\n");
            writer.write("Quantidade: " + quantidade + "\n");
            writer.write("Valor Final: R$ " + valorFinal + "\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        janela.add(lblNome);
        janela.add(lblSobrenome);
        janela.add(lblTelefone);
        janela.add(lblProduto);
        janela.add(lblMassa);
        janela.add(lblRecheio);
        janela.add(lblQuantidade);
        janela.add(lblValorFinal);

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}