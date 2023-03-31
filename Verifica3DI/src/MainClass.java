import java.util.Scanner;

// Chiamare la classe col proprio cognome
public class MainClass
{
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		while(true)
		{
			stampaMenu();
			int scelta = Integer.parseInt(in.nextLine());
			switch(scelta)
			{
				//aggiungere, togliere casi a seconda delle proprie scelte
				case 1:
					MinimoDiArray();
				break;
				case 2:
					ParoleMisteriose();
				break;
				case 3:
					StampaPari();
				break;

				case 4:
					ArrayDivisori();
					break;
				case 5:
					stampaZigZag();
					break;
				default:
					System.out.println("Scelta errata, riprova!");

			}
		}
	}
	
	static void MinimoDiArray()
	{
		int [] array = arrayCasuale(10, -5, 5);
		stampaArray(array);
		
		int indiceMinimo = 0;
		for(int i = 1; i < array.length; i++)
			if(array[indiceMinimo] > array[i])
				indiceMinimo = i;
		
		System.out.println("L'indice del minimo è: " + indiceMinimo + " il valore è: " + array[indiceMinimo]);
	}
	
	static void ParoleMisteriose()
	{
		String[] parole = {"A", "B", "C", "D", "E"};
		
		for(int i = 0; i < 3; i++)
		{
			System.out.println("Inserire la parola da indovinare");
			String parola = in.nextLine();
			for(int j = 0; j < parole.length; j++)
			{
				if(parole[j].equals(parola))
				{
					System.out.println("Bravo! Hai vinto");
					return;
				}
			}
			if(i < 2)
				System.out.println("Non hai vinto, riprova!");
		}
		System.out.println("Non hai vinto!");

	}
	
	static void StampaPari()
	{
		int[] array = arrayCasuale(20, 1, 100);
		stampaArray(array);
		int[] arrayOrdinato = ordinaArray(array);
		
		for(int i = 0; i < arrayOrdinato.length; i++)
			if(arrayOrdinato[i] % 2 == 0)
				System.out.print(arrayOrdinato[i] + " ");
		System.out.println();		
	}
	
	static void ArrayDivisori()
	{
		int[] array = arrayCasuale(50, 1, 100);
		stampaArray(array);
		
		int[] divisori = new int[9];
		
		for(int i = 0; i < divisori.length; i++)
			for(int j = 0; j < array.length; j++)
				if((array[j] % (i + 2)) == 0)
					divisori[i]++;

		stampaArray(divisori);
	}
	
	static void stampaZigZag()
	{
		int[] array = arrayCasuale(10, 0, 10);
		stampaArray(array);
		
		for(int i = 0; i < array.length/2; i++)
		{
			System.out.print(array[i] + " " + array[array.length - i - 1] + " ");
		}
		System.out.println();
		
	}
	
	static void stampaMenu()
	{
		// Modificare il menù secondo le proprie scelte
		System.out.println("1 - MinimoDiArray");
		System.out.println("2 - ParoleMisteriose");
		System.out.println("3 - StampaPari");
		System.out.println("4 - ArrayDivisori");
		System.out.println("5 - stampaZigZag");
	}
	
	static int[] arrayCasuale(int dim, int min, int max)
	{
		int[] array = new int[dim];
		
		for(int i = 0; i < array.length; i++)
			array[i] = (int)(Math.random() * (max - min + 1)) + min;
		
		return array;
	}
	
	static void stampaArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");		
		System.out.println();
	}
	
	static int[] ordinaArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
			for(int j = 0; j < array.length; j++)
				if(array[i]<array[j])
					swap(array,i,j);
		return array;
	}
	
	static void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
