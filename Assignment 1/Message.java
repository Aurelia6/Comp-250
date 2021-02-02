package assignment1;

public class Message {
	
	public String message;
	public int lengthOfMessage;

	public Message (String m){
		message = m;
		lengthOfMessage = m.length();
		this.makeValid();
	}
	
	public Message (String m, boolean b){
		message = m;
		lengthOfMessage = m.length();
	}
	
	/**
	 * makeValid modifies message to remove any character that is not a letter and turn Upper Case into Lower Case
	 */
	public void makeValid(){
		//INSERT YOUR CODE HERE
	}
	
	/**
	 * prints the string message
	 */
	public void print(){
		System.out.println(message);
	}
	
	/**
	 * tests if two Messages are equal
	 */
	public boolean equals(Message m){
		if (message.equals(m.message) && lengthOfMessage == m.lengthOfMessage){
			return true;
		}
		return false;
	}
	
	/**
	 * caesarCipher implements the Caesar cipher : it shifts all letter by the number 'key' given as a parameter.
	 * @param key
	 */
	public void caesarCipher(int key){
		// INSERT YOUR CODE HERE
	}
	
	public void caesarDecipher(int key){
		this.caesarCipher(- key);
	}
	
	/**
	 * caesarAnalysis breaks the Caesar cipher
	 * you will implement the following algorithm :
	 * - compute how often each letter appear in the message
	 * - compute a shift (key) such that the letter that happens the most was originally an 'e'
	 * - decipher the message using the key you have just computed
	 */
	public void caesarAnalysis(){
		// INSERT YOUR CODE HERE
	}
	
	/**
	 * vigenereCipher implements the Vigenere Cipher : it shifts all letter from message by the corresponding shift in the 'key'
	 * @param key
	 */
	public void vigenereCipher (int[] key){
		// INSERT YOUR CODE HERE
	}

	/**
	 * vigenereDecipher deciphers the message given the 'key' according to the Vigenere Cipher
	 * @param key
	 */
	public void vigenereDecipher (int[] key){
		// INSERT YOUR CODE HERE
	}
	
	/**
	 * transpositionCipher performs the transition cipher on the message by reorganizing the letters and eventually adding characters
	 * @param key
	 */
	public void transpositionCipher (int key){
		// INSERT YOUR CODE HERE
	}
	
	/**
	 * transpositionDecipher deciphers the message given the 'key'  according to the transition cipher.
	 * @param key
	 */
	public void transpositionDecipher (int key){
		// INSERT YOUR CODE HERE
	}
	
}
