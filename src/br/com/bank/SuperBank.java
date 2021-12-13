package br.com.bank;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class SuperBank {

	private String nome;
	private int conta, saques;
	private double saldo;
	Scanner entrada = new Scanner(System.in);

	public SuperBank(String nome, int conta, double saldo_inicial) {
		this.nome = nome;
		this.conta = conta;
		saldo = saldo_inicial;
		saques = 0;
	}

	public void extrato() {
		System.out.println("\n\n\tEXTRATO\n");
		System.out.println("Nome: " + this.nome);
		System.out.println("Número da conta: " + this.conta);
		System.out.printf("Saldo atual R$ %.2f\n", this.saldo);
		System.out.println("Saques realizados hoje: " + this.saques + "\n");

	}

	public void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			saques++;
			System.out.println("Sacado R$ " + valor);
			System.out.println("Novo saldo R$ " + saldo + "\n");
		} else {
			System.out.println("Saldo insuficiente. Faça um depósito\n");
		}
	}

	public void depositar(double valor) {
		saldo += valor;
		System.out.println("Depositado R$" + valor);
		System.out.println("Novo saldo R$ " + saldo + "\n");
	}

	public void iniciar() {
		int opcao;

		do {
			exibeMenu();
			opcao = entrada.nextInt();
			escolheOpcao(opcao);
		} while (opcao != 4);
	}

	public void exibeMenu() {

		System.out.println("\n\t Escolha a opção desejada\n\n");
		System.out.println("1 - Consultar Extrato");
		System.out.println("2 - Sacar");
		System.out.println("3 - Depositar");
		System.out.println("4 - Sair\n");
		System.out.print("\n\t\tOpção: ");

	}

	public void escolheOpcao(int opcao) {
		double valor;

		switch (opcao) {
		case 1:
			extrato();
			break;
		case 2:
			if (saques < 3) {
				System.out.print("\nQuanto deseja sacar R$ ");
				valor = entrada.nextDouble();
				sacar(valor);
			} else {
				System.out.println("Limite de saques diários atingidos.\n");
			}
			break;

		case 3:
			System.out.print("\n\nQuanto deseja depositar R$ ");
			valor = entrada.nextDouble();
			depositar(valor);
			break;

		case 4:
			 System.out.println("Sistema encerrado.");
			break;

		default:
			System.out.println("Opção inválida");
		}
	}

	public static void main(String[] args) {
		String nome;
		double inicial;
		Scanner entrada = new Scanner(System.in);
		Random numero = new Random();
		int conta = 1 + numero.nextInt(9999);
		
		Calendar c1 = Calendar.getInstance();
		int hora = c1.get(Calendar.HOUR_OF_DAY);

		int op = 3;
		
		if (hora > 6 && hora < 12) {
			System.out.print("\t\tOla, Bom Dia");
		} else if (hora > 12 && hora < 18) {
			System.out.print("\t\tOla, Boa Tarde");
		} else {
			System.out.print("\t\tOla, Boa Noite");
		}

		System.out.print("\n\nEntre com seu nome: ");
		nome = entrada.nextLine();

		System.out.print("\nEntre com o valor inicial depositado na conta R$ ");
		inicial = entrada.nextDouble();

		SuperBank minhaConta = new SuperBank(nome, conta, inicial);
		minhaConta.iniciar();

	}

}
