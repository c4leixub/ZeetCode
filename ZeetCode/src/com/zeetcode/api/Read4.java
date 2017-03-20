package com.zeetcode.api;


public class Read4 {
	public int read4(char[] buffer) {
		return 4;
	}

	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		int readBytes = 0;
		boolean eof = false;
		
		while (!eof && readBytes < n) {
			int sz = read4(buffer);
			if (sz < 4)
				eof = true;
			
			int bytes = Math.min(n - readBytes, sz);
			
						// src, srcPos, dest, destPos, length
			System.arraycopy(buffer, 0, buf, readBytes, bytes);
			readBytes += bytes;
		}
		
		return readBytes;
	}
}
