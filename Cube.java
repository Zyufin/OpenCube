import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Cube {
  private Map<ArrayList<Integer>, Color> cubemap;//This is the code for the cube data structure, and the various rotations
	private Map<ArrayList<Integer>, Color> tempmap;
	private ArrayList<ArrayList<Integer>> squares;
	private ArrayList<CubePanel> panels;
	private ArrayList<Integer> put;
	private ArrayList<ArrayList<Integer>> meta;
	public Cube(ArrayList<CubePanel> panels){
		cubemap = Collections.synchronizedMap(new HashMap<ArrayList<Integer>, Color>(54));
		tempmap = Collections.synchronizedMap(new HashMap<ArrayList<Integer>, Color>(54));
		meta = new ArrayList<ArrayList<Integer>>(54);
		for(int i = 0; i < 54; i++){
			meta.add(i, new ArrayList<Integer>(3));
		}
		squares = new ArrayList<ArrayList<Integer>>(9);
		put = new ArrayList<Integer>(3);
		this.panels = panels;
		int j = 0;
		for(int i = 1; i <= 3; i++){
			for(int k = 1; k <= 3; k++){
				meta.get(j).add(0, 0); meta.get(j).add(1, i); meta.get(j).add(2, k);//The cube data structure is a HashMap of ArrayLists -> Colors
				cubemap.put(meta.get(j), Color.white);
				meta.get(j+1).add(0, i); meta.get(j+1).add(1, 0); meta.get(j+1).add(2, k);//The location of a 0 or 4 in a specific x, y, or z uniquely identifies a face
				cubemap.put(meta.get(j+1), Color.red);
				meta.get(j+2).add(0, i); meta.get(j+2).add(1, k); meta.get(j+2).add(2, 0);				
				cubemap.put(meta.get(j+2), Color.blue);
				meta.get(j+3).add(0, 4); meta.get(j+3).add(1, i); meta.get(j+3).add(2, k);
				cubemap.put(meta.get(j+3), Color.orange);
				meta.get(j+4).add(0, i); meta.get(j+4).add(1, 4); meta.get(j+4).add(2, k);
				cubemap.put(meta.get(j+4), Color.green);
				meta.get(j+5).add(0, i); meta.get(j+5).add(1, k); meta.get(j+5).add(2, 4);
				cubemap.put(meta.get(j+5), Color.yellow);
				squares.add(j/6, meta.get(j+5));
				j += 6;
			}
		}
	}
	public void up(){					//The various rotations
		if(tempmap.size() > 0){tempmap.clear();}
		Iterator<ArrayList<Integer>> keys = cubemap.keySet().iterator();
		while(keys.hasNext()){
			put.clear();
			ArrayList<Integer> key = keys.next();
			put.add(0, key.get(0)); put.add(1, 4 - key.get(2)); put.add(2, key.get(1));
			tempmap.put(key, cubemap.get(put));
		}
		cubemap.putAll(tempmap);
		for(int i = 0; i<9; i++){
			panels.get(i).repaint();
		}
	}
	public void down(){
		if(tempmap.size() > 0){tempmap.clear();}
		Iterator<ArrayList<Integer>> keys = cubemap.keySet().iterator();
		while(keys.hasNext()){
			put.clear();
			ArrayList<Integer> key = keys.next();
			put.add(0, key.get(0)); put.add(1, key.get(2)); put.add(2, 4-key.get(1));
			tempmap.put(key , cubemap.get(put));
		}	
		cubemap.putAll(tempmap);
		for(int i = 0; i<9; i++){
			panels.get(i).repaint();
		}
	}
	public void right(){
		if(tempmap.size() > 0){tempmap.clear();}
		Iterator<ArrayList<Integer>> keys = cubemap.keySet().iterator();
		while(keys.hasNext()){
			put.clear();
			ArrayList<Integer> key = keys.next();
			put.add(0, 4-key.get(2)); put.add(1, key.get(1)); put.add(2, key.get(0));
			tempmap.put(key, cubemap.get(put));
		}
		cubemap.putAll(tempmap);
		for(int i = 0; i<9; i++){
			panels.get(i).repaint();
		}
	}
	public void left(){
		if(tempmap.size() > 0){tempmap.clear();}
		Iterator<ArrayList<Integer>> keys = cubemap.keySet().iterator();
		while(keys.hasNext()){
			put.clear();
			ArrayList<Integer> key = keys.next();
			put.add(0, key.get(2)); put.add(1, key.get(1)); put.add(2, 4-key.get(0));
			tempmap.put(key, cubemap.get(put));
		}
		cubemap.putAll(tempmap);
		for(int i = 0; i<9; i++){
			panels.get(i).repaint();
		}
	}
	public void up(int idx, int idxval){			//idx and idxval identifies a specific row or column(idxval) in the x, y, or z plane (idx)
		if(tempmap.size() > 0){tempmap.clear();}
		Iterator<ArrayList<Integer>> keys = cubemap.keySet().iterator();
		while(keys.hasNext()){
			put.clear();
			ArrayList<Integer> key = keys.next();
			if(key.get(idx).equals(idxval)){
				put.add(0, key.get(0)); put.add(1, 4 - key.get(2)); put.add(2, key.get(1));
				tempmap.put(key, cubemap.get(put));
			}
		}
		cubemap.putAll(tempmap);
		for(int i = 0; i<9; i++){
			panels.get(i).repaint();
		}
	}
		public void down(int idx, int idxval){
			if(tempmap.size() > 0){tempmap.clear();}
			Iterator<ArrayList<Integer>> keys = cubemap.keySet().iterator();
			while(keys.hasNext()){
				put.clear();
				ArrayList<Integer> key = keys.next();
				if(key.get(idx).equals(idxval)){
					put.add(0, key.get(0)); put.add(1, key.get(2)); put.add(2, 4-key.get(1));
					tempmap.put(key, cubemap.get(put));
				}
			}
			cubemap.putAll(tempmap);
			for(int i = 0; i<9; i++){
				panels.get(i).repaint();
			}
		}
		public void right(int idx, int idxval){
			if(tempmap.size() > 0){tempmap.clear();}
			Iterator<ArrayList<Integer>> keys = cubemap.keySet().iterator();
			while(keys.hasNext()){
				put.clear();
				ArrayList<Integer> key = keys.next();
				if(key.get(idx).equals(idxval)){
					put.add(0, 4-key.get(2)); put.add(1, key.get(1)); put.add(2, key.get(0));
					tempmap.put(key, cubemap.get(put));
				}
			}
			cubemap.putAll(tempmap);
			for(int i = 0; i<9; i++){
				panels.get(i).repaint();
			}
		}
		public void left(int idx, int idxval){
			if(tempmap.size() > 0){tempmap.clear();}
			Iterator<ArrayList<Integer>> keys = cubemap.keySet().iterator();
			while(keys.hasNext()){
				put.clear();
				ArrayList<Integer> key = keys.next();
				if(key.get(idx).equals(idxval)){
					put.add(0, key.get(2)); put.add(1, key.get(1)); put.add(2, 4-key.get(0));
					tempmap.put(key, cubemap.get(put));
				}
			}
			cubemap.putAll(tempmap);

			for(int i = 0; i<9; i++){
				panels.get(i).repaint();
			}
		}
		public Color getColor(ArrayList<Integer> array){	//Feeds colors to the jpanels that represent the cube graphically
			Iterator<ArrayList<Integer>> keys = cubemap.keySet().iterator();
			while(keys.hasNext()){
				ArrayList<Integer> key = keys.next();
				if(key.equals(array)){
					return cubemap.get(key);
				}
			}
				return Color.cyan;
		}
		public ArrayList<ArrayList<Integer>> getArrays(){  //gives the Jframe the 9 applicable squares so it can make jpanels with them
			return squares;
		}
}
