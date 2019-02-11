package com.lkin.matrix.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lkin.trie.Trie;

public class WordSearchTrie {

	Set<String> result = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word); // O(L*W)
		}

		int m = board.length;
		int n = board[0].length;

		boolean[][] visited = new boolean[m][n];

		// O(M*N*W^2)
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, visited, "", i, j, trie);
			}
		}

		return new ArrayList<String>(result);
	}

	// O(S^2) where S is the lenght of S
	public void dfs(char[][] board, boolean[][] visited, String str, int i,
			int j, Trie trie) {
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || j < 0 || i >= m || j >= n) {
			return;
		}

		if (visited[i][j])
			return;

		str = str + board[i][j];

		if (!trie.startsWith(str)) // O(S)
			return;

		if (trie.search(str)) { // O (S)
			result.add(str);
		}

		visited[i][j] = true;
		dfs(board, visited, str, i - 1, j, trie);
		dfs(board, visited, str, i + 1, j, trie);
		dfs(board, visited, str, i, j - 1, trie);
		dfs(board, visited, str, i, j + 1, trie);
		visited[i][j] = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
