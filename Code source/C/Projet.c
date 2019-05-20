#include <18F458.h>
#device ADC=10
#use delay(crystal=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8)
#define BCD_UNITS(x) (x % 10) //unité
#define BCD_TENS(x) (x / 10) //dizaine

void affU(int temp);
void affD(int temp);
void affT(int temp);
void allumeLED(int temp , int max, int min);
void main()
{
   setup_adc_ports(AN0);
   setup_adc(ADC_CLOCK_INTERNAL); //mettre une clock interne
   setup_low_volt_detect(FALSE);
   int max = 30;
   int min = 1;
   int temp = 20;
   
   set_adc_channel(0);
   while(TRUE)
   {
     temp = read_adc() * 100 / 1024; //convertir la tension en température
     allumeLED(temp,max,min); //voir fonction plus bas
     affT(temp);
   }
}

void allumeLED(int temp, int max, int min){
    if(temp > max || temp < min){
     output_high(PIN_B1); //allume la LED rouge
     output_low(PIN_B0); //éteint la LED verte 
   }
   else{
     output_low(PIN_B1); //éteint la LED rouge
     output_high(PIN_B0); //allume la LED verte
   }
}
void affT(int temp){
     while(TRUE){
         affU(temp);
         delay_ms(10);
         affD(temp);
         delay_ms(10);
     }
}
void affU(int temp){
         output_d(BCD_UNITS(temp) | (1 << 4));
         output_low(PIN_D7);
         output_high(PIN_D6);
}
void affD(int temp){
         output_d(BCD_TENS(temp) | (1 << 5));
         output_low(PIN_D6);
         output_high(PIN_D7);
}
