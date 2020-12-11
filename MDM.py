
def Calc_interest(principal, quarters, interest):
    for i in range(quarters):
        principal *= ((interest / 100) + 1)

    return principal

if __name__ == "__main__":
    print(Calc_interest(1000, 4, 10))
