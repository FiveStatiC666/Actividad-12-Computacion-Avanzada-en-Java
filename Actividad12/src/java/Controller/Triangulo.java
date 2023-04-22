package Controller;

public class Triangulo 
{
    private int base;
    private int altura;
    private int perimetro;
    private int area;
    
    public Triangulo(int base, int altura, int perimetro, int area)
    {
        this.base=base;
        this.altura=altura;
        this.perimetro=perimetro;
        this.area=area;
    }
    
    public void setBase(int base)
    {
        this.base=base;
    }
    
    public int getBase()
    {
        return base;
    }
    
    public void setAltura(int altura)
    {
        this.altura=altura;
    }
    
    public int getAltura()
    {
        return altura;
    }
    
    public void setPerimetro(int perimetro)
    {
        this.perimetro=perimetro;
    }
    
    public int getPerimetro()
    {
        return perimetro;
    }
    
    public void setArea(int area)
    {
        this.area=area;
    }
    
    public int getArea()
    {
        return area;
    }
}
