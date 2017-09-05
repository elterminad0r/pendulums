import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PConstants;
import static java.lang.Math.sqrt;
import static java.lang.Math.cos;

public class Pendulum implements PConstants {
  private static PApplet parent;
  private static final float gravity = 10;
  public static float timespeed = 0.4f;
  private float r, l, maxangle, angle, t, period;
  private PVector loc;
  
  public static void init(PApplet app) {
    parent = app;
  }

  public Pendulum(float x, float y, float r, float l, float angle) {
    if (parent == null) {
      throw new Error("not initialised");
    }
    loc = new PVector(x, y);
    this.r = r;
    this.l = l;
    this.angle = angle;
    this.maxangle = angle;
    this.t = 0;
    this.period = 2 * PI * (float)sqrt(l / gravity);
  }

  void draw() {
    PVector bob = PVector.fromAngle(angle + HALF_PI).mult(l).add(loc);
    parent.line(loc.x, loc.y, bob.x, bob.y);
    parent.ellipse(bob.x, bob.y, r*2, r*2);
  }

  void update() {
    t += timespeed;
    angle = maxangle * (float)cos(t * sqrt(gravity / l));
  }
}
