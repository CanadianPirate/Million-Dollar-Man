def Calc_interest(principal, increment, interest, addition, price_growth, div_growth):
    years = 0
    interest /= 100
    price_growth /= 100
    div_growth /= 100
    interest /= increment
    while (principal < 1000000):
        for i in range(increment):
            principal += principal * (price_growth / increment)
            principal += addition
            principal += principal * interest
        interest *= div_growth + 1
        years += 1
    return years



if __name__ == "__main__":

    # Getting data
    assets = float(input("How much cash/assets do you have currently? "))
    interest = float(input("How much interest can you expect to make on the assets you have? (Annual percent as a whole number) "))
    increment = input("How often do you think you will get an investment return? (M or Q) ")
    addition = float(input("How much do you think you will be able to add to your assets in each Month/Quarter? "))
    price_growth = float(input("How much do you expect your stocks to inflate in price per year? (Annual percent as a whole number) "))
    div_growth = float(input("Lastly, How much do you expect your dividend rates to grow per year? (Annual Percent as a whole number)"))

    # Checking increment value
    if increment == "m" or increment == "M":
        increments = 12
    elif increment == "q" or increment == "Q":
        increment = 4
    else:
        pass
    print("It will take you", Calc_interest(assets, increment, interest, addition, price_growth, div_growth), "year(s) to be a million dollar man!")
