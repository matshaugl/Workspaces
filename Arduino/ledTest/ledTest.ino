const int LDR = A0;
const int RED = D8;
const int GREEN = D6;
const int BLUE = D7;
void setup()
{
  Serial.begin(9600);
  pinMode(LDR, INPUT);
  pinMode(RED, OUTPUT);
  pinMode(GREEN, OUTPUT);
  pinMode(BLUE, OUTPUT);
}
void loop()
{
  Serial.print("LDR: ");
  Serial.println(analogRead(LDR));
  analogWrite(RED, random(0,1023));
  analogWrite(GREEN, random(0,1023));
  analogWrite(BLUE, random(0,1023));
  delay(500);
}
