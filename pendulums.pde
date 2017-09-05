Pendulum[] pendulums;

void setup() {
  Pendulum.init(this);
  size(800, 800);
  //change size of array
  pendulums = new Pendulum[100];
  for (int i = 0; i < pendulums.length; i++) {
    pendulums[i] = new Pendulum(width / 2, -400, height / pendulums.length / 4, 400 + map(i, 0, pendulums.length - 1, height / 4, height), 0.3);
  }
}

void draw() {
  background(0);
  fill(255);
  stroke(255);
  strokeWeight(0.3);
  for (Pendulum p : pendulums) {
    p.update();
    p.draw();
  }
}

void keyPressed() {
  switch (keyCode) {
  case 'R':
    setup();
    break;
  case 'F':
    println(frameRate);
    break;
  }
  
  if (key >= '0' && key <= '9') {
    int keyval = key - '0';
    Pendulum.timespeed = 0.4 * keyval;
  }
}
