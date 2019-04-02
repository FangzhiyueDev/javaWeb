package com.fang.net.model;
import java.util.ArrayList;
import java.util.List;
public class Root
{
    private List<Images> images;

    private Tooltips tooltips;

    public void setImages(List<Images> images){
        this.images = images;
    }
    public List<Images> getImages(){
        return this.images;
    }
    public void setTooltips(Tooltips tooltips){
        this.tooltips = tooltips;
    }
    public Tooltips getTooltips(){
        return this.tooltips;
    }
}