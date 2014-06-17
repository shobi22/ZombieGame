/*import java.awt.*;
import java.util.*;
*//**
 * A Zombie is made up of one or more ZombieSegment. The first ZombieSegment is the
 * "head" of the Zombie. The last ZombieSegment is the "tail" of the Zombie. As the
 * Zombie moves, it adds one cell to the head and then removes one from the tail. If
 * the Zombie eats a piece of food, the head adds one cell but the tail will not
 * shrink.
 *//*
public class Zombie {
   private static final int INIT_LENGTH = 12;
      
   public static enum Direction {
      UP, DOWN, LEFT, RIGHT
   }
   
   private Zombie.Direction direction;     // the current direction of the Zombie's head
   
   
   private boolean dirUpdatePending;   // Pending update for a direction change?
   private Random random = new Random();   // for randomly regenerating a Zombie
   
   // Regenerate the Zombie.
   public void regenerate() {
      // Randomly generate a Zombie inside the pit.
      int length = INIT_LENGTH;
      int X = random.nextInt(GameMain.COLUMNS - length * 2) + length;
      int Y = random.nextInt(GameMain.ROWS - length * 2) + length;
      
      direction = Zombie.Direction.values()[random.nextInt(Zombie.Direction.values().length)];
      dirUpdatePending = false;
   }
   
   // Change the direction of the Zombie, but no 180 degree turn allowed.
   public void setDirection(Zombie.Direction newDir) {
      // Ignore if there is a direction change pending and no 180 degree turn
      if (!dirUpdatePending && (newDir != direction)
            && ((newDir == Zombie.Direction.UP && direction != Zombie.Direction.DOWN)
             || (newDir == Zombie.Direction.DOWN && direction != Zombie.Direction.UP)
             || (newDir == Zombie.Direction.LEFT && direction != Zombie.Direction.RIGHT) 
             || (newDir == Zombie.Direction.RIGHT && direction != Zombie.Direction.LEFT))) {
         int x = headSegment.getHeadX();
         int y = headSegment.getHeadY();
         // add a new segment with zero length as the new head segment
         ZombieSegments.add(0, new ZombieSegment(x, y, 0, newDir));
         direction = newDir;
         dirUpdatePending = true; // will be cleared after updated
      }
   }
   
   // Move the Zombie by one step. The Zombie "head" segment grows by one cell. The rest of the 
   // segments remain unchanged. The "tail" segment will later be shrink if collision detected.
   public void update() {
      ZombieSegment headSegment = ZombieSegments.get(0);   // "head" segment
      headSegment.grow();
      dirUpdatePending = false;   // can process the key input again
   }
   
   // Not eaten a food item. Shrink the tail by one cell.
   public void shrink() {
      ZombieSegment tailSegment = ZombieSegments.get(ZombieSegments.size() - 1);
      tailSegment.shrink();
      if (tailSegment.getLength() == 0) {
         ZombieSegments.remove(tailSegment);
      }
   }
   
   // Get the X coordinate of the cell that contains the head of this Zombie segment.
   public int getHeadX() {
      return ZombieSegments.get(0).getHeadX();
   }
   
   // Get the Y coordinate of the cell that contains the head of this Zombie segment.
   public int getHeadY() {
      return ZombieSegments.get(0).getHeadY();
   }
   
   // Returns the length of this Zombie by adding up all the segments.
   public int getLength() {
      int length = 0;
      for (ZombieSegment segment : ZombieSegments) {
         length += segment.getLength();
      }
      return length;
   }
   
   // Returns true if the Zombie contains the given (x, y) cell. Used in collision detection
   public boolean contains(int x, int y) {
      for (int i = 0; i < ZombieSegments.size(); ++i) {
         ZombieSegment segment = ZombieSegments.get(i);
         if (segment.contains(x, y)) {
            return true;
         }
      }
      return false;
   }
   
   // Returns true if the Zombie eats itself
   public boolean eatItself() {
      int headX = getHeadX();
      int headY = getHeadY();
      // eat itself if the (headX, headY) hits its body segment (4th onwards) 
      for (int i = 3; i < ZombieSegments.size(); ++i) {
         ZombieSegment segment = ZombieSegments.get(i);
         if (segment.contains(headX, headY)) {
            return true;
         }
      }
      return false;
   }
   
   // Draw itself.
   public void draw(Graphics g) {
      g.setColor(color);
      for (int i = 0; i < ZombieSegments.size(); ++i) {
         ZombieSegments.get(i).draw(g);   // draw all the segments
      }
      if (ZombieSegments.size() > 0) {
         g.setColor(colorHead);
         g.fill3DRect(getHeadX() * GameMain.CELL_SIZE, getHeadY()
               * GameMain.CELL_SIZE, GameMain.CELL_SIZE - 1,
               GameMain.CELL_SIZE - 1, true);
      }
   }
   
   // For debugging.
   @Override
   public String toString() {
      StringBuffer sb = new StringBuffer();
      sb.append("Zombie[dir=" + direction + "\n");
      for (ZombieSegment segment : ZombieSegments) {
         sb.append("   ").append(segment).append('\n');
      }
      sb.append("]");
      return sb.toString();
   }
}*/