
/*
 * @author ljx
 * @date   Oct 30, 2023 11:58:55 AM
 * @email  ljx.1024@outlook.com
 * @Description 
 * http://118.190.20.162/view.page?gpid=T8
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class _1403_3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br;
		BufferedWriter bw;
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// input format string
		String line = br.readLine();

		HashMap<Character, Boolean> withParaOrNot = new HashMap<Character, Boolean>();
		char[] chArr = line.toCharArray();
		for (int i = 0; i < chArr.length; i++) {
			if (i < chArr.length - 1 && chArr[i + 1] == ':') {
				withParaOrNot.put(chArr[i], true);
				i++;
			} else {
				withParaOrNot.put(chArr[i], false);
			}
		}

		// input n cases
		String[] elems;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			line = br.readLine();
			elems = line.split(" ");
			HashMap<String, String> resPara = new HashMap<String, String>();
			HashSet<String> optionsSet = new HashSet<String>();
			for (int j = 1; j < elems.length; j++) {
				String thisElem = elems[j];
				if (thisElem.startsWith("-") && thisElem.length() == 2) {
					Character optionCharacter = thisElem.charAt(1);
					if (withParaOrNot.get(optionCharacter) == null)
						break;
					boolean withParam = withParaOrNot.get(optionCharacter);
					if (withParam) {
						if (j < elems.length - 1) {
							resPara.put(thisElem, elems[j + 1]);
							j++;
						}
					}
					optionsSet.add(thisElem);

				} else {
					break;
				}

			}
			ArrayList<String> optionList =  new ArrayList<String>();
			optionList.addAll(optionsSet);
			Collections.sort(optionList);

			bw.write("Case " + (i + 1) + ": ");
			for (String string : optionList) {
				bw.write(string + " ");
				String paraString = resPara.getOrDefault(string, null);
				if (paraString != null) {
					bw.write(paraString + " ");
				}
			}
			bw.write("\n");
		}
		bw.close();
	}// main

} // class



/*
albw:x
4
ls -w documents -a -l -a documents -b
ls
ls -w 10 -x -w 15
ls -a -b -c -d -e -l

 */
