package com.fang.rice.updateResponse;

public enum UpdateLeavel {

    updateText(0),
    updateImgAndText(1),
    updateImgAndLink(2),
    updateTextAndLink(4),
    updateImgAndTextAndLink(3),
    updateAll(5);//对于updateAll的功能，就是插入的等级划分

    private int leavel;

    public int getLeavle() {
        return leavel;
    }

    UpdateLeavel(int leavel) {
        this.leavel = leavel;
    }

}
