package guiAssignment;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseScore {
	int score;
	int nCourse;
	String Course;
	String[] CourseArray;
	int[] ScoreArray;
	boolean Nloop;
	boolean dupLoop;
	boolean newLoop;
	String[] newCourseArray;
	int[] newScoreArray;
	int ArrCount = 0;

	Scanner sc = new Scanner(System.in);

	public void nCourse() {
		Nloop = true;
		while (Nloop) {
			try {
				System.out.println("Enter Number of Courses:");
				nCourse = sc.nextInt();
				if (nCourse < 3 || nCourse > 7) {
					System.err.println("Number of Course should be between 3-7");
					continue;
				} else {
					Nloop = false;
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Enter Numbers Only");
				sc.next();
			} catch (Exception e) {
				System.err.println("Enter Numbers Only between 1-7");
				sc.next();
			}
		}
	}

	public void Course() {
		Scanner scCourse = new Scanner(System.in);
		CourseArray = new String[nCourse];
		Nloop = true;
		dupLoop = false;
		newLoop = true;
		int d;

		for (int i = 0; i < nCourse; i++) {
			while (Nloop) {
				try {
					if (i < nCourse) {
						System.out.println("Enter Course[" + (i + 1) + "] Name:");
						Course = scCourse.nextLine();
						if (ArrCount < 1) {
							CourseArray[i] = Course;
							ArrCount++;
						} else {
							dupLoop = false;
							newLoop = false;
							for (d = 0; d < ArrCount; d++) {
								if (CourseArray[d].equalsIgnoreCase(Course)) {
									dupLoop = true;
									newLoop = true;
									System.err.println("Duplicate! Try Again");
									break;
								}
							}

							if (newLoop) {
								continue;
							}
							if (!dupLoop) {
								CourseArray[i] = Course;
								ArrCount++;
							}

						}
					} else {
						Nloop = false;
					}

					break;
				} catch (InputMismatchException e) {
					System.err.println("Enter letters:");
					scCourse.next();
				} catch (Exception e) {
					System.err.println("Enter letters Only:");
					scCourse.next();
				}

			}
		}

//		scCourse.close();
	}

	public void Score() {

		Scanner scScore = new Scanner(System.in);
		ScoreArray = new int[nCourse];
		Nloop = true;
		for (int i = 0; i < nCourse; i++) {
			while (Nloop) {
				try {
					System.out.println("Enter Score[" + (i + 1) + "]: ");
					score = scScore.nextInt();
					if (score < 0 || score > 100) {
						System.err.println("Score should be between 0-100");
						continue;
					} else if (i < nCourse) {
						ScoreArray[i] = score;
					} else {
						Nloop = false;
					}
					break;
				} catch (InputMismatchException e) {
					System.err.println("Enter Numbers Only");
					scScore.next();
				} catch (Exception e) {
					System.err.println("Enter Numbers Only...");
					scScore.next();
				}
			}
		}

	}

	public void grade() {
		for (int i = 0; i < nCourse; i++) {
			if (ScoreArray[i] >= 85) {
				System.out.println(CourseArray[i] + " Grade A");
			} else if (ScoreArray[i] >= 70 && ScoreArray[i] < 85) {
				System.out.println(CourseArray[i] + " Grade B");
			} else if (ScoreArray[i] >= 50 && ScoreArray[i] < 65) {
				System.out.println(CourseArray[i] + " Grade C");
			} else if (ScoreArray[i] >= 45 && ScoreArray[i] < 50) {
				System.out.println(CourseArray[i] + " Grade D");
			} else {
				System.out.println(CourseArray[i] + " Grade F");
			}
		}
	}

	public void changeScore(String CourseName, int newScore) {

		for (int i = 0; i < nCourse; i++) {
			if (CourseArray[i].equals(CourseName)) {
				ScoreArray[i] = newScore;
				Nloop = true;
				break;
			} else {
				Nloop = false;
			}
		}
		if (!Nloop) {
			System.err.println(CourseName + " Doesn't Exist!");
		}
	}

	public void addCourse(String CourseName) {
		nCourse += 1;
		newCourseArray = new String[nCourse];
		newScoreArray = new int[nCourse];
		dupLoop = false;
		newLoop = true;
		String newCourse = CourseName;
		int d;


		 	for (d = 0; d < CourseArray.length; d++) {
				dupLoop = false;
				if (CourseArray[d].equalsIgnoreCase(newCourse)) {
					dupLoop = true;
					nCourse -= 1;
					break;
				} else {
					newCourseArray[d] = CourseArray[d];
				}
			}
			
		if (!dupLoop) {
			
			newCourseArray[newCourseArray.length - 1] = newCourse;
//			ArrCount++;
			CourseArray = newCourseArray;
			Scanner addScore = new Scanner(System.in);
			Nloop = true;
			while (Nloop) {
				try {
					System.out.println("Enter Score for the New Course:");
					score = addScore.nextInt();
					if (score < 0 || score > 100) {
						System.err.println("Score should be between 0-100");
						continue;
					} else {
						for (int i = 0; i < ScoreArray.length; i++) {
							newScoreArray[i] = ScoreArray[i];
						}
						int newScore = score;
						newScoreArray[newScoreArray.length - 1] = newScore;
						ScoreArray = newScoreArray;
						System.out.println(Arrays.toString(ScoreArray));
						System.out.println(Arrays.toString(CourseArray));
					}
					break;
				} catch (InputMismatchException e) {
					System.err.println("Enter Numbers Only");
					addScore.next();
				} catch (Exception e) {
					System.err.println("Enter Numbers Only...");
					addScore.next();
				}
			}
		} 
		else {
			System.out.println("Course Already Exist");

		}
	}

	public void checkScore(String CourseName) {
		String CheckCourse = CourseName;
		for (int i = 0; i < nCourse; i++) {
			if (newCourseArray[i].equalsIgnoreCase(CheckCourse)) {
				System.out.println("The Score for " + CheckCourse + " is " + newScoreArray[i]);
				Nloop = true;
				break;
			} else {
				Nloop = false;
			}
	 	}
		if (!Nloop) {
			System.out.println("No " + CheckCourse + " in Courses");
			
		}
	}

	public static void main(String[] args) {
		CourseScore obj = new CourseScore();
		obj.nCourse();
		obj.Course();
		obj.Score();
		
		System.out.println("-----------Change Score-------------");
		obj.changeScore("English", 86);
		
		System.out.println("-----------grade-------------");
		obj.grade();
		
		System.out.println("-----------add Course-------------");
		obj.addCourse("Maths");
		obj.addCourse("CRS");
		
		obj.addCourse("Maths");
		obj.addCourse("English");
		
		System.out.println("-----------check Score-------------");
		obj.checkScore("English");
	}

}
