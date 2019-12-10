package edu.niu.z1839171.shipcalculator;

public class ShippingItem
{
    //constants
    static final Double BASE_AMOUNT = 3.00,
            ADDED_AMOIUNT = 0.50,
            EXTRA_OUNCES = 4.0;

    static  final Double BASE_WEIGHT = 16.0;

    //Variables
    private Integer weight;
    private  Double baseCost, addedCost, totalCost;

    //Constructor of class
    public ShippingItem()
    {
        weight = 0;
        baseCost = BASE_AMOUNT;
        addedCost = 0.0;
        totalCost = 0.0;
    }

    public void setWeight(Integer newWeight)
    {
        this.weight = newWeight;
        computeCost();
    }//end setWeight method

    public void computeCost()
    {
        baseCost = BASE_AMOUNT;
        if(weight <= 0)
            baseCost = 0.0;

        //Calculate the additional weight
        if(weight > BASE_WEIGHT)
            addedCost = Math.ceil((weight - BASE_WEIGHT)/EXTRA_OUNCES ) * ADDED_AMOIUNT;

        //Calculate the Total Cost
        totalCost = baseCost + addedCost;
    }//end computeCost

    public Double getBaseCost() {
        return baseCost;
    }

    public Double getAddedCost() {
        return addedCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }
}
