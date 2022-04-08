public class baseConverter {
	public static void main (String args[]) {
		int oldBase = Integer.parseInt(args[1]);
		
		String filePath = args[0];
		// String fileName = filePath.substring(filePath.lastIndexOf("/") != -1 ? filePath.lastIndexOf("/") : 0, filePath.length());
		In inputFile = new In(filePath);
		
		String code = inputFile.readString();
		inputFile.close();
		
		String[] codeValues = new String[code.length()];
		
		for (int i = 0; i < code.length(); i++) {
			codeValues[i] = (int) code.charAt(i) + "";
		}
		
		Out output = new Out("out.txt");
		
		for (int i = 0; i < codeValues.length; i++) {
			int[] conversionArr = new int[codeValues[i].length()];
			for (int j = 0; j < codeValues[i].length(); j++) {
				int result = 0;
				conversionArr[j] = Integer.parseInt(codeValues[i].charAt(codeValues[i].length()-j-1) + "");
				for (int k = 0; k < conversionArr.length; k++) {
					result += conversionArr[k] * oldBase * k;
				}
				output.print((char) result);
			}
		}
	}   
}