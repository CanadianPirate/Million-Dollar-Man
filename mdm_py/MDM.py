""" Additon list
Vars: starting cash, expected interest, years of return, quarters/montly increments, quarterly/montly addiditons

"""

def Calc_interest(principal, increments, interest):
    for i in range(increments):
        principal *= ((interest / 100) + 1)

    return principal

if __name__ == "__main__":
    print(Calc_interest(1000, 4, 10))
