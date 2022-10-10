package com.ciandt.nextgen.faculdade;

import java.util.Arrays;

public class TestaVetores {

    public static void main(String[] args) {  
        huandy();
    }

    public static void huandy() {
        String vet[] = {"b", "e", "c", "a", "d"};
        imprimeVetor(vet);
        int p = Arrays.binarySearch(vet, "e");
        System.out.println("POSICAO: " + p);
        Arrays.sort(vet);
        System.out.println("depois de organizar");
        imprimeVetor(vet);
        p = Arrays.binarySearch(vet, "e");
        System.out.println("POSICAO: " + p);
    }

    public static void guanabara() {
        int vet[] = {3, 7, 6, 1, 9, 4, 2};
        imprimeVetor(vet);
        int p = Arrays.binarySearch(vet, 3);
        System.out.println("POSICAO: " + p);
        Arrays.sort(vet);
        System.out.println("depois de organizar");
        imprimeVetor(vet);
        p = Arrays.binarySearch(vet, 3);
        System.out.println("POSICAO: " + p);
    }

    private static void imprimeVetor(int[] vet) {
        for (int i = 0; i < vet.length; ++i) {
            System.out.println("vet[" + i + "] = " + vet[i]);
        }
    }

    private static void imprimeVetor(Object[] vet) {
        for (int i = 0; i < vet.length; ++i) {
            System.out.println("vet[" + i + "] = " + vet[i]);
        }
    }

    public static void bruxao() {
        // int n[] = new int[4];
        // n[0] = 3;
        // n[1] = 2;
        // n[2] = 8;
        // n[3] = 7;
        int n[] = {3,2,8,7};
        // n[4] = 10;

        int soma = 0;
        for (int posicao = 0; posicao < n.length; posicao++) {
            soma += n[posicao];
        }
        double media = soma / n.length;

        System.out.println(soma);
        System.out.println(media);
    }
}