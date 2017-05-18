package com.wdm.spr;

public class BraveKnightAop implements Knight {

    private Quest quest;

    public BraveKnightAop(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embark() {
        quest.bark();
    }
}
