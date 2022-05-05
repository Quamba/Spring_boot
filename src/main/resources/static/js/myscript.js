const barCanvas = document.getElementById("barCanvas");
const barChart = new Chart(barCanvas,{
      type :"bar",
      data :{
           labels:["Janvier","Fevrier","Mars","Avril","Mai","Juin","Juiellet","Aout","Septembre","Octobre","Novembre","Decembre"],
           datasets:[{
              label: 'Meilleure vente',
              data:[20,5,6,12,3,9,10,11,2,6,3,16],
              backgroundColor:[
                  "black","red","pink","yellow","crimson","blue","lime","violet","purple","brown","gray","orange"
                ]
             }]
         }

   });