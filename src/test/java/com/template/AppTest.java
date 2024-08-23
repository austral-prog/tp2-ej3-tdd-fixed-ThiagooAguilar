package com.template;

import org.junit.jupiter.api.Test;

import javax.xml.validation.Validator;
import java.util.HashMap;
import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 15);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }
    @Test
    void testCrearCuentaConSaldoInicial() {
        Map<String, Integer> cuenta = new HashMap<>();
        Map<String, Integer> cuenta_creada = CrearCuentaConSaldoInicial("Thiago");
        assertEquals(0,cuenta_creada.get("Thiago"));
    }
    @Test
    void testSaldonegativo() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 15);
        Map<String,Integer> confirmacion = deposit( accounts,"mati", -20);
        assertEquals(15, confirmacion.get("juan"));
        assertEquals(10, confirmacion.get("mati"));

    }
    @Test
    void testNoExistencia() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 15);
        Map<String,Integer> existence = deposit( accounts,"Francisco", 20);
        assertEquals(15, existence.get("juan"));
        assertEquals(10, existence.get("mati"));
    }
    @Test
    void testRetire() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 15);
        Map<String, Integer> updateaccounts = retire(accounts, "mati", 9);
        assertEquals(1, updateaccounts.get("mati"));
    }
    @Test
    void testnegativeretire() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 15);
        Map<String,Integer> updateaccounts = retire(accounts, "mati", -9);
        assertEquals(10,updateaccounts.get("mati"));
        assertEquals(15,updateaccounts.get("juan"));
    }
    @Test
    void testretireexistence() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 15);
        Map<String,Integer> updateaccounts = retire(accounts, "Federico", 20 );
        assertEquals(15, updateaccounts.get("juan"));
        assertEquals(10,updateaccounts.get("mati"));
    }
    @Test
    void testretirezero() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 0);
        accounts.put("juan", 15);
        Map<String,Integer> mensaje = retire(accounts, "mati", 30);
        assertEquals(15, mensaje.get("juan"));
        assertEquals(0, mensaje.get("mati"));
    }
    @Test
    void testTransference() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 15);
        Map<String, Integer> updateaccounts = Transference(accounts, "juan","mati", 5 );
        assertEquals(10,updateaccounts.get("juan"));
        assertEquals(15,updateaccounts.get("mati"));
    }

    @Test
    void testTransferencezero() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 0);
        accounts.put("juan", 15);
        Map<String,Integer> updateaccounts= Transference(accounts, "mati", "juan", 8);
        assertEquals(15, updateaccounts.get("juan"));
        assertEquals(0,  updateaccounts.get("mati"));
    }
    @Test
    void testTransferenceexistence() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 15);
        Map<String,Integer> updateaccounts = Transference(accounts, "Federico", "Gustavo", 20);
        assertEquals(15, updateaccounts.get("juan"));
        assertEquals(10, updateaccounts.get("mati"));
    }

    @Test
    void testNegativeTransference() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 15);
        Map<String,Integer> updateaccounts = Transference(accounts, "mati", "juan", -20);
        assertEquals(15, updateaccounts.get("juan"));
        assertEquals(10, updateaccounts.get("mati"));
    }

    @Test
    void testSameperson() {
        Map<String , Integer> accounts = new HashMap<>();
        accounts.put("mati", 10);
        accounts.put("juan", 15);
        Map<String, Integer> updateaccounts= Transference(accounts, "mati", "mati", 20);
        assertEquals(10, updateaccounts.get("mati"));
        assertEquals(15, updateaccounts.get("juan"));
    }
}
