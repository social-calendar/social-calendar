// 时间日期选择器组件
/*
@param floatingText 浮动文本内容
*/
import React from 'react';
import ReactDOM from 'react-dom';

import DatePicker from 'material-ui/DatePicker';
import TimePicker from 'material-ui/TimePicker';
import TextField from 'material-ui/TextField';
import Formate from './Formate.js';


class DateTime extends React.Component{
    constructor(props){
        super(props);
        this.handleDateDismiss=this.handleDateDismiss.bind(this);
        this.handleTextFocus=this.handleTextFocus.bind(this);
        this.handleDateChange=this.handleDateChange.bind(this);
        this.handleTimeChange=this.handleTimeChange.bind(this);
        this.handleDateTimeChange=this.handleDateTimeChange.bind(this);


        var now=new Date();
        this.state={
            date:Formate.formate(now,'date'),
            time:Formate.formate(now,'time'),
            dateTime:Formate.formate(now)
        }
    }
    handleTextFocus(event){
        this.refs.myDate.focus();
    }

    handleDateChange(event,date){
        this.setState({
            date:Formate.formate(date,'date')
        });
    }
    handleTimeChange(event,time){
        this.setState({
            time:Formate.formate(time,'time')
        });
    }
    handleDateDismiss(event){
        this.refs.myTime.focus();
    }
    handleDateTimeChange(){
        this.setState({
            dateTime:this.state.date+" "+this.state.time
        });
    }
    //获取值
    getValue(){
        return this.state.dateTime;
    }
    //设置值
    setValue(str){
        this.setState({
            dateTime:str
        });
    }
    render(){
        return (
            <div>
                <TextField 
                    onFocus={this.handleTextFocus} 
                    value={this.state.dateTime}
                    onChange={this.handleDateTimeChange}
                    id="dateTime"
                    floatingLabelText={this.props.floatingText}
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

export default DateTime;
