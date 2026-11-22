package Modelo;

public class Alcancia
{
    private int monedas50;
    private int monedas100;
    private int monedas200;
    private int monedas500;
    private int monedas1000;

    public Alcancia()
    {
        this.monedas50 = 0;
        this.monedas100 = 0;
        this.monedas200 = 0;
        this.monedas500 = 0;
        this.monedas1000 = 0;
    }

    public boolean agregarMonedas(int valor)
    {
        switch (valor)
        {
            case 50:
                monedas50++;
                return true;
            case 100:
                monedas100++;
                return true;
            case 200:
                monedas200++;
                return true;
            case 500:
                monedas500++;
                return true;
            case 1000:
                monedas1000++;
                return true;
            default:
                return false;
        }
    }

    public int getSaldo()
    {
        return (monedas50 * 50)
             + (monedas100 * 100)
             + (monedas200 * 200)
             + (monedas500 * 500)
             + (monedas1000 * 1000);
    }

    public int getTotalMonedas()
    {
        return monedas50 + monedas100 + monedas200 + monedas500 + monedas1000;
    }

    public int getMonedas50()
    {
        return monedas50;
    }

    public int getMonedas100()
    {
        return monedas100;
    }

    public int getMonedas200()
    {
        return monedas200;
    }

    public int getMonedas500()
    {
        return monedas500;
    }

    public int getMonedas1000()
    {
        return monedas1000;
    }

    public void vaciar()
    {
        monedas50 = 0;
        monedas100 = 0;
        monedas200 = 0;
        monedas500 = 0;
        monedas1000 = 0;
    }
}
