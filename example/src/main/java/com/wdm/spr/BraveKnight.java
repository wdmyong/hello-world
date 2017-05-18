package com.wdm.spr;

public class BraveKnight implements Knight {

    private Quest quest;
    private Minstrel minstrel;

    public BraveKnight(Quest quest, Minstrel minstrel) {
        this.minstrel = minstrel;
        this.quest = quest;
    }

    @Override
    public void embark() {
        minstrel.beforeOperation();
        quest.bark();
        minstrel.afterOperation();
    }
}
