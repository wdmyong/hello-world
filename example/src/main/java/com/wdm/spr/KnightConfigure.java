package com.wdm.spr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfigure {

    @Bean
    Quest quest() {
        Quest quest = new FirstQuest();
        return quest;
    }

    @Bean
    Minstrel minstrel() {
        Minstrel minstrel = new Minstrel(System.out);
        return minstrel;
    }

    @Bean
    Knight knight() {
        Knight knight = new BraveKnight(quest(), minstrel());
        return knight;
    }
}
