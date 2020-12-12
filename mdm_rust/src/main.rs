use text_io::read;

// Function to check compounding interest
fn calc_interest(mut principal: f64, increment: u32, mut interest: f64, addition: f64, mut price_growth: f64, mut div_growth: f64) -> f64 {
    let mut years: f64 = 0.0;
    interest /= 100.0;
    interest /= increment as f64;
    price_growth /= 100.0;
    div_growth /= 100.0;
    while principal < 1000000.0{
        for _ in 0..increment {
            principal += principal * price_growth;
            principal += addition;
            principal += interest * principal;
        }
        interest *= div_growth + 1.0;
        years += 1.0;
    }
    return years
}

fn main() {

    // Getting data
    println!("How much cash/assets do you have currently? ");
    let assets: f64 = read!();
    println!("How much interest can you expect to make on the assets you have? (Annual percent as a whole number) ");
    let interest: f64 = read!();
    println!("How often do you think you will get an investment return? (M or Q) ");
    let increment_type: String = read!();
    println!("How much do you think you will be able to add to your assets in each Month/Quarter? ");
    let addition: f64 = read!();
    println!("How much do you expect your stocks to inflate in price per year? (Annual percent as a whole number) ");
    let price_growth: f64 = read!();
    println!("Lastly, How much do you expect your dividend rates to grow per year? (Annual Percent as a whole number)");
    let div_growth: f64 = read!();
    let mut increment: u32 = 4;

    // Checking Increment
    if increment_type == "m" || increment_type == "M" {
        increment = 12;
    }


    println!("It will take you {} year(s) to be a million dollar man.", calc_interest(assets, increment, interest, addition, price_growth, div_growth));


}
