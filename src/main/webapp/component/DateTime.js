// 时间日期选择器组件
/*
@param floatingText 浮动文本内容
@param defaultValue 默认时间
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

        this.getValue=this.getValue.bind(this);

        this.state={
            date:Formate.formate(this.props.defaultValue,'date'),
            time:Formate.formate(this.props.defaultValue,'time'),
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
    //获取值
    getValue(){
        return this.state.date+" "+this.state.time;
    }
    render(){
        return (
            <div>
                <TextField 
                    onFocus={this.handleTextFocus} 
                    value={this.getValue()}
                    default={this.props.defaultValue}
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
DateTime.defaultProps = { defaultValue: new Date() };

export default DateTime;
