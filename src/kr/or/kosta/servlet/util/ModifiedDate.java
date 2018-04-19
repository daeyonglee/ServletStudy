package kr.or.kosta.servlet.util;

import java.io.File;
import java.util.Comparator;

public class ModifiedDate implements Comparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		
		File file1 = (File)obj1;
		File file2 = (File)obj2;
		
		if (file1.lastModified() > file2.lastModified()) return -1;
		if (file1.lastModified() == file2.lastModified()) return 0;
		return 1;
	}

}
