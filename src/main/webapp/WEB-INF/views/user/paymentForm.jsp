<form action="<%= request.getContextPath() %>/payment" method="post">
    <input type="hidden" name="userId" value="${userId}">
    <input type="hidden" name="reservationId" value="${reservationId}">
    Amount: <input type="text" name="amount"><br>
    Payment Date: <input type="text" name="paymentDate" placeholder="yyyy-mm-dd"><br>
    Payment Method: 
    <select name="paymentMethod">
        <option value="Credit Card">Credit Card</option>
        <option value="PayPal">PayPal</option>
        <option value="Bank Transfer">Bank Transfer</option>
    </select><br>
    <input type="submit" value="Submit Payment">
</form>
