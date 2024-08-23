package com.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class App {


    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        if (amount < 0) {
            System.out.println("Realizar un deposito negativo no se permite.");
            return accounts;
        }else if (!accounts.containsKey(account)) {
            System.out.println("Realizar un deposito en una cuenta no existente no se permite.");
            return accounts;
        }
        else {
            int currentMoney = accounts.get(account);
            int newMoney = currentMoney + amount;
            accounts.put(account, newMoney);
            return accounts;
        }

    }

    public static Map<String, Integer> CrearCuentaConSaldoInicial(String nombre) {
        Map<String, Integer> cuenta = new HashMap();
        int Money = 0;
        cuenta.put(nombre, Money);
        return cuenta;
    }
    public static Map<String, Integer> retire(Map<String, Integer> accounts, String account, int amount) {
        if (amount < 0) {
            System.out.print("Realizar un retiro negativo no se permite.");
            return accounts;
        } else if (!accounts.containsKey(account)) {
            System.out.print("Realizar un retiro en una cuenta no existente no se permite");
            return accounts;
        }else if (accounts.get(account) == 0){
            System.out.print("Realizar un retiro en la cuenta sin saldo no se permite.");
            return accounts;
        }
        else {
            int currentMoney = accounts.get(account);
            int newMoney = currentMoney - amount;
            accounts.put(account, newMoney);
            return accounts;
        }
    }
    public static Map<String, Integer> Transference(Map<String, Integer> accounts, String personaquetransfiere, String personaquerecibe, int monto) {

        if (!accounts.containsKey(personaquetransfiere)) {
            System.out.print("Realizar una transferencia entre cuentas no existentes no se permite.");
            return accounts;
        }
        else if (accounts.get(personaquetransfiere)==0) {
            System.out.print("Realizar una transferencia entre cuentas sin saldo no se permite.");
            return accounts;
        } else if (monto<0){
            System.out.print("Realizar una transferencia negativa no se permite.");
            return accounts;
        }
        else if (personaquetransfiere.equals(personaquerecibe)){
            System.out.print("Realizar una transferiencia entre la misma cuenta no se permite");
            return accounts;
        }
        else {
            int currentMoney = accounts.get(personaquetransfiere);
            int newMoney = currentMoney - monto;
            int currentMoney2 = accounts.get(personaquerecibe);
            int newMoney2 = currentMoney2 + monto;
            accounts.put(personaquetransfiere, newMoney);
            accounts.put(personaquerecibe, newMoney2);
            return accounts;
        }
    }
}

