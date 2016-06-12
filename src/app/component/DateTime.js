import React from 'react';
import ReactDOM from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';

import DatePicker from 'material-ui/DatePicker';
import TimePicker from 'material-ui/TimePicker';
import TextField from 'material-ui/TextField';
import MyTheme from './MyTheme.js';

injectTapEventPlugin();

class DateTime extends React.Component{
    constructor(props){
        super(props);
        this.handleDateDismiss=this.handleDateDismiss.bind(this);
        this.handleTextFocus=this.handleTextFocus.bind(this);
        // this.getDateTime=this.getDateTime.bind(this);


    }
    handleTextFocus(event){
        this.refs.myDate.focus();
        var dateTime=this.refs.myDate.value+" "+this.refs.myTime.value;
        this.refs.myDateTime.value=dateTime;
        console.log('时间日期'+this.refs.myDateTime.value);
    }
    // getDateTime(){
    //     return this.refs.myDate.value+" "+this.refs.myTime.value;
    // }
    handleDateDismiss(event){
         this.refs.myTime.focus();
        console.log(this.refs.myDate.value);

    }
    render(){
        return (
            <div>
                <TextField hintText="Hint Text" 
                    onFocus={this.handleTextFocus} 
                    ref="myDateTime"
                    // value={this.refs.myDate.value+" "+this.refs.myTime.value}
                />
                <DatePicker hintText="开始日期" 
                    onDismiss={this.handleDateDismiss} 
                    autoOk={true}
                    ref="myDate"
                    id="date"
                />
                <TimePicker hintText="开始时间" format="24hr"
                    ref="myTime"
                    style={{display:'none'}} 
                />
            </div>
        );
    }
};

ReactDOM.render(
    <MuiThemeProvider muiTheme={MyTheme} >
        <DateTime />
    </MuiThemeProvider>,
    document.getElementById('test')
);
