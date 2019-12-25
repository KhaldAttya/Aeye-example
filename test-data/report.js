
const arr = [
    "Sample Test",
            ]
const arrPics = [
  
  "sampleTest"
]



var i=0;
var all = []

setTimeout(() => {
  
  for(i=0;i<arrPics.length;i++){
    var html =`
    <div class="screens">
    <h3>${arrPics[i]}</h3>
    <table style="width:100%">
        <tr>
          <th></th>
          <th>Native Android</th>
          <th>Native iOS</th>
          <th>React Android</th>
          <th>React iOS</th>
        </tr>
        <tr id="expected">
          <td>Expected</td>
          <th><img src="native-android/samsung-s8/expected/${arrPics[i]}.png" height=616  width=300 ></img></th>
            <th><img src="native-ios/iPhone-7/expected/${arrPics[i]}.png" height=616  width=300 ></img></th>
                <th><img src="react-android/samsung-s8/expected/${arrPics[i]}.png" height=616  width=300 ></img></th>
                    <th><img src="react-ios/iPhone-7/expected/${arrPics[i]}.png" height=616  width=300 ></img></th>
                    </tr>
                    </tr>
                    <tr id="actual">
                      <td>Actual</td>
                      <th><img src="native-android/samsung-s8/actual/${arrPics[i]}.png" height=616  width=300 ></img></th>
                        <th><img src="native-ios/iPhone-7/actual/${arrPics[i]}.png" height=616  width=300 ></img></th>
                            <th><img src="react-android/samsung-s8/actual/${arrPics[i]}.png" height=616  width=300 ></img></th>
                                <th><img src="react-ios/iPhone-7/actual/${arrPics[i]}.png" height=616  width=300 ></img></th>
                                </tr>
                
                      </tr>
                      <tr id="result">
                        <td>Result</td>
                        <th><img src="native-android/samsung-s8/result/${arrPics[i]}.png" height=616  width=300 ></img></th>
                          <th><img src="native-ios/iPhone-7/result/${arrPics[i]}.png" height=616  width=300 ></img></th>
                              <th><img src="react-android/samsung-s8/result/${arrPics[i]}.png" height=616  width=300 ></img></th>
                                  <th><img src="react-ios/iPhone-7/result/${arrPics[i]}.png" height=616  width=300 ></img></th>
                                  </tr>
      </table>  
    </div>
    `
    let frag = document.createRange().createContextualFragment(html);
    let view = document.getElementById('main').append(frag)
    
    }

}, 2000); 