import getMuiTheme from 'material-ui/styles/getMuiTheme';
import {tealA700} from 'material-ui/styles/colors';

const MyTheme = getMuiTheme({
      palette: {
        primary1Color:tealA700,
        primary2Color: tealA700,
        pickerHeaderColor:tealA700
      },
      appBar: {
        height: 50,
      },
});

export default MyTheme;