fn calc_interest(mut principal: f64, increments: u32, interest: f64) -> f64{
    for _ in 0..increments {
        principal = principal * ((interest / 100.0) + 1.0);
    }
    return principal
}

fn main() {
    println!("Your final amount is {}", calc_interest(1000.0, 4, 10.0));
}
