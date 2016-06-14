// 时间日期选择器组件
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
        this.handleDateChange=this.handleDateChange.bind(this);
        this.handleTimeChange=this.handleTimeChange.bind(this);
        this.getDateTime=this.getDateTime.bind(this);
        var now=new Date();
        this.state={
            date:now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate(),
            time:now.getHours()+":"+now.getMinutes()
        }
    }
    handleTextFocus(event){
        this.refs.myDate.focus();
    }
    getDateTime(){
        return this.state.date+" "+this.state.time;
    }
    handleDateChange(event,date){
        this.setState({
            date:date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()
        });
    }
    handleTimeChange(event,time){
        this.setState({
            time:time.getHours()+":"+time.getMinutes()
        });
    }
    handleDateDismiss(event){
        this.refs.myTime.focus();
    }
    render(){
        return (
            <div>
                <TextField 
                    onFocus={this.handleTextFocus} 
                    value={this.getDateTime()}
                    id="dateTime"
                />
                <DatePicker hintText="开始日期" 
                    ref="myDate"
                    onDismiss={this.handleDateDismiss} 
                    autoOk={true}
                    onChange={this.handleDateChange}
                    style={{display:'none'}}
                />
                <TimePicker hintText="开始时间" format="24hr"
                    ref="myTime"
                    onChange={this.handleTimeChange}
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
