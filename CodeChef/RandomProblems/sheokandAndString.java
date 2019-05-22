import java.util.Arrays;
import java.util.Scanner;

class node {
	node child[] = new node[26];
	boolean isEnd;

	public node() {
		isEnd = false;
		for (int i = 0; i < 26; i++) {
			child[i] = null;
		}
	}
}

class query implements Comparable<query> {
	int R, index;
	String S;

	query(int r, String s, int i) {
		R = r;
		S = s;
		index = i;
	}

	@Override
	public int compareTo(query o) {
		// TODO Auto-generated method stub
		return this.R - o.R;
	}
}

public class sheokandAndString {
	static node root;

	static node create(String s) {
		if (root == null) {
			root = new node();
		}
		node temp = root;
		for (int i = 0; i < s.length(); i++) {
			if (temp.child[s.charAt(i) - 'a'] == null) {
				temp.child[s.charAt(i) - 'a'] = new node();
			}
			temp = temp.child[s.charAt(i) - 'a'];
		}
		temp.isEnd = true;
		return root;
	}

	static StringBuilder search(String key) {
		node temp = root;
		StringBuilder ans = new StringBuilder();
		int i = 0;
		for (i = 0; i < key.length(); i++) {
			if (temp.child[key.charAt(i) - 'a'] == null) {
				break;
			}
			ans.append(key.charAt(i));
			temp = temp.child[key.charAt(i) - 'a'];
		}
		if (i != key.length() - 1) {
			return ans;
		}
		while (true) {
			int flag = 0;
			for (int j = 0; j < 26; j++) {
				if (temp.child[j] != null) {
					ans.append((char) (97 + j));
					temp = temp.child[j];
					flag = 1;
				}
			}
			if (flag == 0) {
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String strings[] = new String[N];
		for (int i = 0; i < N; i++) {
			strings[i] = sc.next();
		}
		int Q = sc.nextInt();
		query q[] = new query[Q];
		for (int i = 0; i < Q; i++) {

			int tempInt = sc.nextInt();

			String eat = sc.nextLine();

			String tempStr = sc.next();
			q[i] = new query(tempInt, tempStr, i);
		}
		int added = 0;
		Arrays.sort(q);
		for (int i = 0; i < Q; i++) {
			if (added != q[i].R) {
				for (int j = added; j < q[i].R; j++) {
					create(strings[j]);
				}
				added = q[i].R - 1;
				System.out.println(search(q[i].S));
			}
		}
	}
}
