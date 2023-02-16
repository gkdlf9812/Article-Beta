package My_Articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0; //인덱싱을 위해 만든 변수 
		List<Article> articles = new ArrayList<>(); //type article인 array list 만들거야. 그리고 그 array list의 이름을 articles로 할거야.

		while (true) {//무한루프 참이기 때문에 무한반복
			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				//만약에 문자열의 크기가 0이면 아무것도 입력 안됬다는 뜻
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (command.equals("system exit")) {
				//프로그렘 종료를 원하면 
				break;
			}

			if (command.equals("article list")) {
				//글 목록 보기
				
				if (articles.size() == 0) {
					//만약에 articles라는 배열의 크기가 0 이면 사실상 안에 아무것도 들어있는게 아님.
					System.out.println("게시글이 없습니다");
				} 
				
				else {
					//만약에 articles라는 배열 안에 뭐가 들어있다면...
					System.out.println("  번호   /   제목  ");
					for (int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf("  %d    /   %s  \n", article.id, article.title);
						//배열안에 해당하는 index에 저장된 article 라는 객체 속에 있는 객체 속성 중에 id, title 의 값들을 접근해서 출력할거야.
					}
				}

			} else if (command.equals("article write")) {
				//글 추가 하기
				
				
				int id = lastArticleId + 1; // id의 초기 값은 사실상 0 + 1. 왜냐하면 lastArticleID = 0. 0+1 = 1 
				
				System.out.println("before" + lastArticleId);
				System.out.println("before" + id);
				
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);
				//article 이라는 변수에 new Article 객체 넣어줌. 
				//입력 할 때 마다 저장을 해야되니 서로 다른 article 객체가 articles 배열안에 있는 결과가 됨.
				articles.add(article);//articles 배열에 article 객체 추가하는 작업.

				System.out.println(id + "번 글이 생성되었습니다");
				lastArticleId++; // +1 증가시켜줌.
				
				System.out.println("After" + id);
				System.out.println("After" + lastArticleId);
				
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}

		System.out.println("==프로그램 끝==");

		sc.close();
	}
}

class Article {
	int id;
	String title;
	String body;

	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

}