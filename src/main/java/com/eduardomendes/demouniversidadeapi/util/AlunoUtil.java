package com.eduardomendes.demouniversidadeapi.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AlunoUtil {

    public static String gerarCodigoMatricula(){
        LocalDateTime date = LocalDateTime.now();
        String recibo = date.toString().substring(0,19);
        return recibo.replace("-", "")
                .replace(":", "")
                .replace("T", "-");
    }
}
