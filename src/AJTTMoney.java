import java.util.Currency;
import java.math.RoundingMode;
import java.math.BigDecimal;

public class AJTTMoney {
	private static final Currency USD = Currency.getInstance("USD");
    private static final RoundingMode ROUNDING = RoundingMode.HALF_EVEN;
	private BigDecimal _amount; 

	AJTTMoney() {
		setAmount(new BigDecimal(0));
	}
	AJTTMoney(BigDecimal amount) {
		this.setAmount(amount);
	}
	AJTTMoney(AJTTMoney money) {
		this.setAmount(money.amount());
	}

	public void setAmount(BigDecimal amount) {
		_amount = amount.setScale(USD.getDefaultFractionDigits(), ROUNDING);
	}

	public BigDecimal amount() {
		return _amount;
	}
	@Override
	public String toString() {
		return String.format("$" + amount());
	}
}